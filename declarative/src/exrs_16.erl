%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 22. May 2020 15:39
%%%-------------------------------------------------------------------
-module(exrs_16).
-author("idotsenko").

%% API
-export([group_fishes/1]).

group_fishes(Fishes) ->
  NamesGroupedByType = [ {Type2, [Name  || {Name, Type} <- Fishes, Type2 == Type ] } || {_Name2, Type2} <- Fishes],
  dedup(NamesGroupedByType).

dedup([{Type, Names}| NamesGroupedByType]) ->
  OtherTypes = remove_given_type(NamesGroupedByType, {Type, Names}),
%% Append given type to result list. It's unique now
  [ {Type, Names} | dedup(OtherTypes) ];

dedup([]) -> [].


remove_given_type([{TypeToCheck, Name} | Duplicates], ElementToDedup) ->
  case {TypeToCheck, Name} == ElementToDedup of
%%  Skip duplicate
    true -> remove_given_type(Duplicates, ElementToDedup);
%%  Keep an element which is different. We will dedup it later
    false -> [ {TypeToCheck, Name} | remove_given_type(Duplicates, ElementToDedup)]
  end;

remove_given_type([], _ElementToDedup) -> [].