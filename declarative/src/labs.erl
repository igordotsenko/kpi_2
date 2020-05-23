%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 15. May 2020 17:08
%%%-------------------------------------------------------------------
-module(labs).
-author("idotsenko").

%% API
-export([lab_10/0, lab_11/0, lab_12/0, lab_13/0, lab_14/0, lab_15/0, lab_16/0, lab_17/0]).
-import(exrs_10,[surface_class/4]).
-import(exrs_11,[calculate_function/2]).
-import(exrs_12,[calculate/4]).
-import(exrs_13,[append_sum/1]).
-import(exrs_15,[matrix_sub_sum/1]).
-import(exrs_17,[map_with_bid/1, map_with_guard/1, map_with_case/1]).

lab_10() -> 
  io:fwrite("~w ~n", [exrs_10:surface_class(2, 3, same_k)]),
  io:fwrite("~w ~n", [exrs_10:surface_class(3, 3, different_k)]),
  io:fwrite("~w ~n", [exrs_10:surface_class(3, 4, negative_delta, same_k)]),
  io:fwrite("~w ~n", [exrs_10:surface_class(3, 4, positive_delta, same_k)]).

lab_11() ->
%% Expected 1 for next 3 cases
  io:fwrite("~w ~n", [exrs_11:calculate_function(-1, -1)]),
  io:fwrite("~w ~n", [exrs_11:calculate_function(-1, 0)]),
  io:fwrite("~w ~n", [exrs_11:calculate_function(-1, 1)]),
%%  Expected 1 *1 + 2 = 3
  io:fwrite("~w ~n", [exrs_11:calculate_function(1, 1)]),
%%  3 + (2*1 + 2) = 7
  io:fwrite("~w ~n", [exrs_11:calculate_function(1, 2)]),
%%  Error
  io:fwrite("~w ~n", [exrs_11:calculate_function(1, -1)]).

lab_12() ->
%%  Empty list
  io:fwrite("~w ~n", [exrs_12:calculate(1, 0, 1, 1)]),
%%  Empty 2 elements
  io:fwrite("~w ~n", [exrs_12:calculate(1, 2, 1, 1)]),
%%  Empty 3 elements
  io:fwrite("~w ~n", [exrs_12:calculate(1, 4, 1.5, 5)]),
%% error
  io:fwrite("~w ~n", [exrs_12:calculate(1, 5, 1.5, 0)]).

lab_13() ->
  %%  Empty list
  io:fwrite("~w ~n", [exrs_13:append_sum([])]),
%%  First element is the last element so it's [2, 4]
  io:fwrite("~w ~n", [exrs_13:append_sum([2])]),
%%  1+3 = 4 so it's [1, 2, 3, 4]
  io:fwrite("~w ~n", [exrs_13:append_sum([1, 2, 3])]),
  %%  input [1, 2, 3, 4] => 1+4 = 5 => result [1, 2, 3, 4, 5]
  io:fwrite("~w ~n", [exrs_13:append_sum(exrs_13:append_sum([1, 2, 3]))]).

lab_14() ->
  %%  Empty list
  io:fwrite("~w ~n", [exrs_14:remove_last_third([])]),
%%  [1, 2] expected
  io:fwrite("~w ~n", [exrs_14:remove_last_third([1, 2, 3])]),
%%  [1, 2, 3, 4] expected
  io:fwrite("~w ~n", [exrs_14:remove_last_third([1, 2, 3, 4, 5, 6])]),
%%  Error since 7 / 3 != 0
  io:fwrite("~w ~n", [exrs_14:remove_last_third([1, 2, 3, 4, 5, 6, 7])]).

lab_15() ->
%%  0
  io:fwrite("~w ~n", [exrs_15:matrix_sub_sum([
    []
  ])]),
%%  0
  io:fwrite("~w ~n", [exrs_15:matrix_sub_sum([
    [1]
  ])]),
  %% 5 + 7 + 8 = 20
  io:fwrite("~w ~n", [exrs_15:matrix_sub_sum([
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8]
  ])]),
  %% 7 + 10 + 11 + 13 + 14 + 15 = 70
  io:fwrite("~w ~n", [exrs_15:matrix_sub_sum([
    [0, 1, 2, 3],
    [4, 5, 6, 7],
    [8, 9, 10 ,11],
    [12, 13, 14, 15]
  ])]).

lab_16() ->
  Res = exrs_16:group_fishes([
    {fish1, predator},
    {fish2, predator},
    {fish11, non_predator},
    {fish4, predator},
    {fish13, non_predator},
    {fish14, non_predator}
  ]),
  Res.
  

lab_17() ->
  L = [ 1.2, 2, 0, -1.3, -1, -0.9, -0.1],
%%  Expected [ 1.2, 2, 0, -1.3, 1, 0.9, 0.1]
  io:fwrite("~w ~n", [exrs_17:map_with_guard(L)]),
  io:fwrite("~w ~n", [exrs_17:map_with_case(L)]),
  io:fwrite("~w ~n", [exrs_17:map_with_bid(L)]).