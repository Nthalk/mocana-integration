#!/usr/bin/env bash

mvn clean generate-resources generate-sources compile package android:deploy android:run
adb logcat -c
