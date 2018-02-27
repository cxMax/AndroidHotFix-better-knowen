package com.cxmax.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project


public class Register implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def log = project.logger
        log.error "========================";
        log.error "Javassist开始修改Class!";
        log.error "========================";
        project.android.registerTransform(new PreDexTransform(project))
    }
}
