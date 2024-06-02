import com.congdanh.compositebuild.get
import com.congdanh.compositebuild.implementation
import com.congdanh.compositebuild.kapt
import com.congdanh.compositebuild.libs
import com.congdanh.compositebuild.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {
        pluginManager.run {
            apply(libs.plugin("kotlin.kapt").pluginId)
            apply(libs.plugin("hilt").pluginId)
        }

        dependencies {
            implementation(libs["hilt.android"])
            kapt(libs["hilt.compiler"])
        }
    }
}
