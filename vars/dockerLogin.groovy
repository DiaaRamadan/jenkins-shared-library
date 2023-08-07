#!/usr/bin/env groovy
import com.jenkins.Docker

def call() {
    return new Docker(this).dockerLogin()
}