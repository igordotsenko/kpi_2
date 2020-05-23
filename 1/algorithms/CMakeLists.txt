cmake_minimum_required(VERSION 3.12)
project(algorithms C)

set(CMAKE_C_STANDARD 99)

add_library(algorithms library.c library.h dotsenko.c)
add_executable(simple_example dotsenko.c)