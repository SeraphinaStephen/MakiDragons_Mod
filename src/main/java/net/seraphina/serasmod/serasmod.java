package net.seraphina.serasmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.seraphina.serasmod.item.ModToolTiers;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(serasmod.MOD_ID)
public class serasmod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "seras_mod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public serasmod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the mod's commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the ModEventSubscriber's items to the event bus
        ModEventSubscriber.ITEMS.register(modEventBus);

        // Register the Deferred Register to the EventBus
        modEventBus.addListener(this::addCreative);

        // Register the mod to the global Minecraft Forge event bus
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup code (e.g., network or game logic initialization)
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModEventSubscriber.LUCKYSEVEN.get());
            event.accept(ModEventSubscriber.SYTHE.get());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Code to run when the server is starting
    }

    @Mod.EventBusSubscriber(modid = serasmod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventSubscriber {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, serasmod.MOD_ID);

        // Register the LUCKYSEVEN item
        public static final RegistryObject<SwordItem> LUCKYSEVEN = ITEMS.register("luckyseven", () -> new SwordItem(
                        ModToolTiers.SAPPHIRE, // The item tier (defined below)
                        10, // Attack damage (base + bonus)
                        -.5F, // Attack speed modifier
                        new Item.Properties() // General item properties
                )
        );

        public static final RegistryObject<SwordItem> SYTHE = ITEMS.register("serensythe", () -> new SwordItem(
                        ModToolTiers.SAPPHIRE, // The item tier (defined below)
                        99999999, // Attack damage (base + bonus)
                        -.5F, // Attack speed modifier
                        new Item.Properties() // General item properties
                )
        );

        @SubscribeEvent
        public static void onCommonSetup(FMLCommonSetupEvent event) {
            // Add any other common setup tasks here
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Add client-side setup code here
        }
    }
}
