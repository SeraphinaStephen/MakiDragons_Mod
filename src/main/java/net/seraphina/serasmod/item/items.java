package net.seraphina.serasmod.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.seraphina.serasmod.serasmod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class items {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, serasmod.MOD_ID);

    public static final RegistryObject<SwordItem> LUCKYSEVEN = ITEMS.register("luckyseven",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 10, 2, new Item.Properties()));

    public static final RegistryObject<SwordItem> SYTHE = ITEMS.register("serensythe",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 999999, 2, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
