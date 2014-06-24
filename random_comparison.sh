#!/bin/bash

set -e

seq 10 | parallel -u ~/workspace/jpf-core/bin/jpf +seqlistener.output=no_random_seq_{}.txt +cg.randomize_choices=NONE dts-random.jpf
seq 10 | parallel -u ~/workspace/jpf-core/bin/jpf +seqlistener.output=no_random_seq_{}.txt dts-random.jpf

