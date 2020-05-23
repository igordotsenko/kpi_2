%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 23. May 2020 15:03
%%%-------------------------------------------------------------------
-module(exrs_17).
-author("idotsenko").

%% API
-export([map_with_guard/1, map_with_case/1, map_with_bid/1]).


%% Guard
map_with_guard([]) -> [];
map_with_guard([Head | Tail]) when Head >= -1, Head < 0 ->
[map_el(Head) | map_with_guard(Tail)];

map_with_guard([Head | Tail]) ->
[ Head | map_with_guard(Tail)].

%% Case
map_with_case([]) -> [];

map_with_case([Head | Tail]) ->
  case should_be_inverted(Head) of
    true -> [inverse(Head) | map_with_case(Tail)];
    false -> [Head | map_with_case(Tail)]
  end.

%% BID
map_with_bid([]) -> [];
map_with_bid(List) ->
  lists:map(fun(E) -> map_el(E) end, List).


%% Util

should_be_inverted(E) -> (E >= -1) and (E < 0).
inverse(E) -> -1 * E.
map_el(E) when E >= -1, E < 0 -> -1 * E;
map_el(E) -> E.






