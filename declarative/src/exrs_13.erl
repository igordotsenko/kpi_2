%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 19. May 2020 17:39
%%%-------------------------------------------------------------------
-module(exrs_13).
-author("idotsenko").

%% API
-export([append_sum/1]).



append_sum([]) ->[];

append_sum(List) when length(List) == 1 ->
  lists:append(List, []);

append_sum(List) ->
  List ++ [sum(List)].

sum([First | Rest]) ->
  First + lists:last(Rest).