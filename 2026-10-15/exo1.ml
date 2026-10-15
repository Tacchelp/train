let gen_list f n =
  let rec aux f n acc =
    if n = -1 then acc
    else aux f (n - 1) (f n :: acc)
  in
  aux f (n - 1) []

let rand_list n =
  gen_list (fun x -> Random.int n) n

let int_list n =
  gen_list (fun x -> x) n

let time f x =
  Gc.compact();
  let temp = Unix.gettimeofday() in
  f x, (Unix.gettimeofday() -. temp )*. 1000.

let insert_sort comp l =
  let rec ins lt x =
    match lt with
    |[] -> [x]
    |a::q ->
      if comp x a <= 0 then a::(ins q x)
      else x :: a :: q
  in
  List.rev (List.fold_left ins [] l)


let rec quick_sort (comp : 'a -> 'a -> int) (l : 'a list) : 'a list =
  let rec sep (pivot : 'a) (liste : 'a list) (left : 'a list) (right : 'a list) : 'a list * 'a list =
    match liste with
    |[] -> (left, right)
    |x::q -> if comp x pivot < 0 then sep pivot q (x :: left) right else sep pivot q left (x :: right)
  in
  
  match l with
  |[] -> []
  |x::q -> 
    let left, right = sep x q [] [] in
    (quick_sort comp left) @ [x] @ (quick_sort comp right)

let test_sort (trie : 'a list -> 'a list) (n : string) (size : int list) : unit =
  begin
  Random.init 42;
  Printf.printf "%s\n" n;
  let rec loop (l : int list) : unit =
    match l with
    |[] -> ()
    |x::q -> 
      begin
      Printf.printf "%d (trié) %f\n %d (random) %f\n" x (snd (time trie (int_list x))) x (snd (time trie (rand_list x))); 
      loop q
      end
  in
  loop size
  end


let () =
  test_sort (insert_sort compare) "insert_sort" [0; 1; 10; 20; 50; 100];
  test_sort (quick_sort  compare) "quick_sort"  [0; 1; 10; 20; 50; 100]