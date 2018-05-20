# scalajs-base-x

[![Build Status](https://api.travis-ci.org/christobill/scalajs-base-x.svg?branch=1-bootstrapping)](https://travis-ci.org/christobill/scalajs-base-x)

The aim of [scalajs-base-x](https://github.com/christobill/scalajs-base-x) to mimic npm module [base-x](https://www.npmjs.com/package/base-x)
This produce an non-standard base x (x being a positive Integer) String encoding/decoding.

There are several goals:
- provide an isofunctionnal `jvm` implementation of [base-x](https://www.npmjs.com/package/base-x)
- allow users to use this implementation in `scalajs` cross-builded project
- provide a facade for [base-x](https://www.npmjs.com/package/base-x)
- test thoroughly this facade (thus the `nodejs` code) with `scalacheck` to know its limitations
- increase the type safety of [scalajs-base-x](https://github.com/christobill/scalajs-base-x) and overcome `nodejs` implementation limitations
- publish a [scalajs-base-x](https://github.com/christobill/scalajs-base-x) version on npm
