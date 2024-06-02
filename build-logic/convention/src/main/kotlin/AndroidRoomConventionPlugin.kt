import com.congdanh.compositebuild.annotationProcessor
import com.congdanh.compositebuild.get
import com.congdanh.compositebuild.implementation
import com.congdanh.compositebuild.libs
import com.congdanh.compositebuild.plugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) = target.run {
        dependencies {
            implementation(libs["room.runtime"])
            implementation(libs["room.ktx"])
            annotationProcessor(libs["room.compiler"])
        }
    }
}
