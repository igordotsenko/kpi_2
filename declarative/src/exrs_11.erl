%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 18. May 2020 16:17
%%%-------------------------------------------------------------------
-module(exrs_11).
-author("idotsenko").

%% API
-export([calculate_function/2]).

calculate_function(X, _N) when X < 0 -> 1;
calculate_function(X, N) when X > 0, N >= 0 -> sum(1, X, N).

sum(_K, _X, 0) -> 0;
sum(K, X, N) -> do_calculate(K, X) + sum(K+1, X, N-1).
do_calculate(K, X) -> K*X+2.