#!/usr/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t diaa96/shopme:backend-1.0 ./ShopmeWebParent/ShopmeBackend/'
        sh 'docker build -t diaa96/shopme:frontend-1.0 ./ShopmeWebParent/ShopmeFrontend/'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push diaa96/shopme:backend-1.0'
        sh 'docker push diaa96/shopme:frontend-1.0'
    }
}