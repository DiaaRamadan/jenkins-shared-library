#!/usr/bin/env groovy

def call(String imageName) {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t $imageName:backend-1.0 ./ShopmeWebParent/ShopmeBackend/"
        sh "docker build -t $imageName:frontend-1.0 ./ShopmeWebParent/ShopmeFrontend/"
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName:backend-1.0"
        sh "docker push $imageName:frontend-1.0"
    }
}