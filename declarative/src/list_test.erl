%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. May 2020 16:00
%%%-------------------------------------------------------------------
-module(list_test).
-author("idotsenko").

%% API
-export([main/1]).


main([Head|[Body|Tail]]) ->
  io:fwrite("~w\n", [Head]),
  io:fwrite("~w\n", [Body]),
  io:fwrite("~w\n", [Tail]).