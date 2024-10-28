/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.github.leo40git.streamwatcher

import dev.kord.common.entity.Snowflake
import dev.kordex.core.ExtensibleBot
import dev.kordex.core.utils.env
import io.github.leo40git.streamwatcher.extensions.TestExtension

val TEST_SERVER_ID = Snowflake(
	env("TEST_SERVER").toLong()  // Get the test server ID from the env vars or a .env file
)

private val TOKEN = env("TOKEN")   // Get the bot' token from the env vars or a .env file

suspend fun main() {
	val bot = ExtensibleBot(TOKEN) {
		extensions {
			add(::TestExtension)
		}
	}

	bot.start()
}