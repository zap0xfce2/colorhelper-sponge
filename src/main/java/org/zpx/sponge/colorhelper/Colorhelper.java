package org.zpx.sponge.colorhelper;

import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.plugin.Plugin;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;
import com.google.inject.Inject;
import org.spongepowered.api.plugin.PluginContainer;


@Plugin(id = "clolorhelper", name = "Colorhelper", version = "7.2.1", authors = "Zap0xfce2",
        url = "https://github.com/zap0xfce2/colorhelper-sponge",
        description = "Helps you with the color codes.")
public class Colorhelper {

    @Inject
    private Logger logger;
    @Inject
    private PluginContainer container;

    @Listener
    public void onServerStart(GameStartedServerEvent ServerStartEvent) {

        CommandSpec base = CommandSpec.builder()
                .permission("colorhelper.use")
                .description(Text.of("Shows the Colorhelper."))
                .executor((src, args) -> {
                    src.sendMessage(toColoredText("&b-------------------- Colorhelper --------------------"));
                    src.sendMessage(toColoredText("&4Darkred (4)&f, &cRed (c)&f, &6Gold (6)&f, &eYellow (e)&f, &2Dark Green (2)&f, &aGreen (a)&f, &bAqua (b)&f, &3Dark Aqua (3)&f, &1Dark Blue (1)&f, &9Blue (9)&f, &dLight Purple (d)&f, &5Dark Purple (5)&f, &fWhite (f)&f, &7Gray (7)&f, &8Dark Gray (8)&f, &0Black (0)&f, "));
                    src.sendMessage(toColoredText("&lBold (l)&r, &nUnderline (n)&r, &oItallic (o)&r, &kMagic &f(k)&r, &mStrike (m)&r, &rReset (r)"));
                    src.sendMessage(toColoredText("&b-------------------- Colorhelper --------------------"));
                    return CommandResult.success();
                }).build();
        Sponge.getCommandManager().register(this, base, "colorhelper");
        Sponge.getCommandManager().register(this, base, "ch");

        // Log Start Up to Console
        logger.info(
                container.getName() + " version " + container.getVersion().orElse("")
                        + " enabled!");

    }

    public static Text toColoredText(String str){
        return TextSerializers.FORMATTING_CODE.deserialize(str);
    }

}