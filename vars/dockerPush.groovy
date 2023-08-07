#!/usr/bin/env groovy
import com.jenkins.Docker

def call(String imageName) {
    return new Docker(this).dockerPush(imageName)
}