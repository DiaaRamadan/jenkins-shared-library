#!/usr/bin/env groovy

package com.jenkins

class Pom {

    def script

    Pom(script) {
        this.script = script
    }

    def incrementVersion(String pomPath){
        sh "mvn -f $pomPath build-helper:parse-version versions:set \
        -DnewVersion=\${parsedVersion.majorVersion}.\
        \${parsedVersion.minorVersion}.\
        \${parsedVersion.nextIncrementalVersion} \
        versions:commit"
    }

    def getPomVersion(String path){
        def matcher = readFile($path) =~ '<version>(.+)</version>'
        return matcher[0][1 as String]
    }

}
