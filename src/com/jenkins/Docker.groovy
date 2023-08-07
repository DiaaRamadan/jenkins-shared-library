#!/usr/bin/env groovy
package com.jenkins;

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def dockerBuildImage(String imageName, String path) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName $path"
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }

}
