#!/usr/bin/env groovy
import com.jenkins.Docker

def call(String imageName, String path) {
    return new Docker(this).dockerBuildImage(imageName, path)
}