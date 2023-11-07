#!/bin/bash

jflex lcalc.flex
java java_cup.Main < ycalc.cup
javac Main.java


