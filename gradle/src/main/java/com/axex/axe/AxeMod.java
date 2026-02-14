package com.axex.axe;

import com.axex.axe.item.ThrowAxeItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(AxeMod.MODID)
public class AxeMod {

    public static final String MODID = "axe_or_ex";

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> THROWABLE_AXE =
            ITEMS.register("throwable_axe",
                    () -> new ThrowAxeItem(
                            Tiers.IRON,
                            8.0F,
                            -3.0F,
                            new Item.Properties().stacksTo(1)
                    ));

    public AxeMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(bus);
        MinecraftForge.EVENT_BUS.register(this);
    }
}
