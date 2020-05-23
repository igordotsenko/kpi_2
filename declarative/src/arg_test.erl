%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. May 2020 16:45
%%%-------------------------------------------------------------------
-module(arg_test).
-author("idotsenko").

%% API
-export([test/1]).


test(Arg0) when Arg0 >= 0 -> '0';
test(_Arg0) -> '1'.
