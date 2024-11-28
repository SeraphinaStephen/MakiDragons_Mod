package net.seraphina.serasmod.datagen;


import net.minecraft.world.item.SwordItem;
import net.seraphina.serasmod.serasmod;
import net.seraphina.serasmod.item.items;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, serasmod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

        handheldItem(items.LUCKYSEVEN);
        handheldItem(items.SYTHE);

    }

    private ItemModelBuilder handheldItem(RegistryObject<SwordItem> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(serasmod.MOD_ID,"item/" + item.getId().getPath()));
    }

}
