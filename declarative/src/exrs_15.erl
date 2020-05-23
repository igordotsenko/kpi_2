%%%-------------------------------------------------------------------
%%% @author idotsenko
%%% @copyright (C) 2020, <COMPANY>
%%% @doc
%%%
%%% @end
%%% Created : 21. May 2020 15:22
%%%-------------------------------------------------------------------
-module(exrs_15).
-author("idotsenko").

%% API
-export([matrix_sub_sum/1]).

%% If it was an imperative language, I'd do:
%% sum = 0
%% for row in matrix, row_index = 0:
%%    if row_index == 0: row_index+=1, continue

%%    for i = row_index; i > 0; i--:
%%       sum += row[len(matrix)-i]]
%%    row_index += 1


matrix_sub_sum(Matrix) when length(Matrix) =< 1 -> 0;
matrix_sub_sum(Matrix) ->
  calculate(Matrix, 0, length(Matrix)).

%% We reached the end of the matrix
calculate(_Rows, RowI, MatrixSize) when RowI == MatrixSize -> 0;
%% Sum elements of the current row and the elements in the next rows
calculate([Row | Rest], RowI, MatrixSize) ->
  row_sum(Row, RowI, MatrixSize) + calculate(Rest, RowI+1, MatrixSize).

%% We reached the end of the elements that are below the diagonal
row_sum(_Row, RowI, _MatrixSize) when RowI == 0 -> 0;
%% Sum row elements that are below the diagonal
row_sum(Row, RowI, MatrixSize) ->
  lists:nth(MatrixSize-RowI+1, Row) + row_sum(Row, RowI-1, MatrixSize).