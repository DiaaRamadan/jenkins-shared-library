#!/usr/bin/env groovy
package com.jenkins;

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildImage(String imageName) {
        script.echo "building the docker image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
            script.sh "docker build -t $imageName:backend-1.0 ./ShopmeWebParent/ShopmeBackend/"
            script.sh "docker build -t $imageName:frontend-1.0 ./ShopmeWebParent/ShopmeFrontend/"
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            script.sh "docker push $imageName:backend-1.0"
            script.sh "docker push $imageName:frontend-1.0"
        }
    }

}
