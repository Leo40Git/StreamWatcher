package io.github.leo40git.streamwatcher.extensions

import dev.kordex.core.checks.isBotOwner
import dev.kordex.core.extensions.Extension
import dev.kordex.core.extensions.publicSlashCommand
import dev.kordex.core.i18n.withContext
import io.github.leo40git.streamwatcher.TEST_SERVER_ID
import io.github.leo40git.streamwatcher.i18n.Translations

class DevEnvironmentExtension : Extension() {
	override val name = "dev-environment"

	override suspend fun setup() {
		publicSlashCommand {
			name = Translations.Commands.Shutdown.name
			description = Translations.Commands.Shutdown.description

			guild(TEST_SERVER_ID)

			check {
				isBotOwner()
			}

			action {
				respond {
					content = Translations.Commands.Shutdown.response
						.withContext(this@action)
						.translate()
				}

				this@DevEnvironmentExtension.bot.close()
			}
		}
	}
}
