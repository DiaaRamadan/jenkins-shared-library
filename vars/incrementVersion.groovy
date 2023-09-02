#!/usr/bin/env groovy

import com.jenkins.Pom

def call(String pomPath){
    return new Pom(this).incrementVersion(pomPath)
}