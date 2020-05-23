%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 15. May 2020 16:46
%%%-------------------------------------------------------------------
-module(exrs_10).
-author("idotsenko").

%% API
-export([
  surface_class/3,
  surface_class/4
]).


surface_class(2, 3, same_k) -> 'Elliptical cylinder';
surface_class(3, 3, different_k) -> 'Conical surface'.
surface_class(3, 4, negative_delta, same_k) -> 'Ellipsoid';
surface_class(3, 4, positive_delta, same_k) -> 'Imaginary Ellipsoid'.
