-module(hello).
-export([hello_world/0, args/0, list/0]).
-import(arg_test, [test/1]).

hello_world() -> 
  module_test:double(2).
args() ->
  io:fwrite("~w ~n", [arg_test:test()]).

list() ->
  List = [1, 2],
  List_End = [List, 1, 2],
  io:fwrite("~w ~n", [[1 , 2 | List]]),
  io:fwrite("~w ~n", [List_End]).