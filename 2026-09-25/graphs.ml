(* Implementation de graphs pondere avec des matrices d'adjacence *)
(* g.(i).(j) = 3 signifie que i->j avec le poids 3*)
open PriorityQueue

type graph = int array array

let isArrete (g : graph) (i : int) (j : int) : bool =
  i != j && g.(i).(j) != -1

let setArrete (g : graph) (i : int) (j : int) (poids : int): unit =
  g.(i).(j) <- poids

let getArrete (g : graph) (i : int) (j : int) : int =
  g.(i).(j)

let degre_sortant (g : graph) (i : int) : int =
  let rec aux (n :int) (acc : int) =
    if n = -1 then acc
    else 
      if isArrete g i n then aux (n - 1) (acc + 1)  
      else aux (n - 1) acc
  in
  aux (Array.length g.(i) - 1) 0

let degre_entrant (g : graph) (i : int) : int =
  let rec aux (n : int) (acc : int) =
    if n = -1 then acc
    else
      if isArrete g n i then aux (n - 1) (acc + 1)
      else aux (n - 1) acc
  in
  aux (Array.length g - 1) 0

let a = Array.make_matrix 2 2 (-1)


(* [("A", inf)] *)
let dijkstra (g : graph) (i : int) : int array * int array =
  let dist = Array.make (Array.length g) max_int in
  let pred = Array.make (Array.length g) (-1)    in
  let vu   = Array.make (Array.length g) false   in
  let a_traite = PriorityQueue.create (-1) in

  begin
    dist.(i) <- 0;
    pred.(i) <- i;
    PriorityQueue.push a_traite i (dist.(i));
    while not (PriorityQueue.isEmpty a_traite) do
      let u = PriorityQueue.pop a_traite in
      if not vu.(u) then begin
        for j = 0 to Array.length g - 1 do
          if isArrete g u j then 
            if dist.(j) > dist.(u) + (getArrete g u j) then begin
              dist.(j) <- dist.(u) + (getArrete g u j);
              pred.(j) <- u;
              if not vu.(j) then PriorityQueue.push a_traite j (dist.(j))  
            end
        done;
      vu.(u) <- true
      end
    done;
    dist, pred
  end

let path (g : graph) (i : int) (j : int) : int list =
  let _, pred = dijkstra g i in
  let rec aux (j : int) : int list =
    if j = i then [i]
    else j :: (aux pred.(j))
  in
  List.rev (aux j)
