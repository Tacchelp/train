let max_size = 256

type 'a heap = {
  mutable size : int;
  data         : (int * 'a) array
  }

let isEmpty (h : 'a heap) : bool =
  h.size = 0

let swap (h : 'a heap) (i : int) (j : int) : unit =
  begin
    let temp = h.data.(i) in
    h.data.(i) <- h.data.(j);
    h.data.(j) <- temp;
  end


let rec buble_up (h : 'a heap) (i : int) : unit =
  if fst h.data.(i) < fst h.data.((i - 1) / 2) then begin
    let parent = (i - 1) / 2 in
    swap h i parent;
    buble_up h parent
  end

let rec sink_down (h : 'a heap) (n : int) : unit =
  let left = 2 * n + 1 in
  let right = 2 * (n + 1) in
  let minimum (h : 'a heap) (i : int) (j : int) : int =
    if fst (h.data.(i)) < fst (h.data.(j)) then i
    else j
  in
  if right < h.size then begin
    let m = minimum h (minimum h left right) n in
    if m <> n then begin
        swap h m n;
        sink_down h m;
      end
    end
  else if left < h.size then
    let m = minimum h left n in
    if m <> n then swap h n m

let push (h : 'a heap) (elt : 'a) (priority : int) : unit =
  if h.size + 1 > max_size then failwith "Out of space"
  else
    begin
      h.data.(h.size) <- (priority, elt);
      h.size <- h.size + 1;
      buble_up h (h.size - 1)
    end

let pop (h : 'a heap) : 'a =
  if isEmpty h then failwith "h is empty"
  else
    begin
      swap h 0 (h.size - 1);
      h.size <- h.size - 1;
      sink_down h 0;
      snd h.data.(h.size)
    end

let create (elt : 'a) : 'a heap =
  {size = 0; data = Array.make max_size (0, elt)}
