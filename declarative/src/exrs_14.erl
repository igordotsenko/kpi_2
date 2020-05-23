%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 21. May 2020 14:54
%%%-------------------------------------------------------------------
-module(exrs_14).
-author("idotsenko").

%% API
-export([remove_last_third/1]).

remove_last_third([]) -> [];
remove_last_third(List) when length(List) rem 3 == 0 -> 
  remove_last_third(List, 0, 2*length(List) div 3).

%% add elements to a new list unit will reach the start of the third part
remove_last_third(_List, I, TailStart) when I >= TailStart-> [];
remove_last_third([Head | Rest], I, TailStart) ->
  [Head|remove_last_third(Rest, I+1, TailStart)].