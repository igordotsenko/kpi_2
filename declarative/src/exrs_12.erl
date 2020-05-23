%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 19. May 2020 17:07
%%%-------------------------------------------------------------------
-module(exrs_12).
-author("idotsenko").

%% API
-export([calculate/4]).


calculate(X, Xf, H, N) when N >= 1 ->
  do_calculate(X, Xf+H/100, H, N).


do_calculate(X, Xf, _H, _N) when X > Xf -> [];

do_calculate(X,Xf,H,N) when X =< Xf ->
  [ func(X, N, 1) + math:sin(X*X)| do_calculate(X+H, Xf, H, N) ].


func(X, N, I) when I < N ->
  1/(X*X+I) + func(X, N, I+1);

func(_X, N, I) when I >= N -> 0.