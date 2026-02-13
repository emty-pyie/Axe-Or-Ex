package com.axex.axe;

import com.axex.axe.network.ModNetwork;
import com.axex.axe.registry.ModEntities;
import com.axex.axe.registry.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AxeMod.MODID)
public class AxeMod {

    public static final String MODID = "axe_or_ex"; // ← use your real mod id

    public AxeMod() {

        IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modBus);
        ModEntities.register(modBus);

        ModNetwork.register();
    }
}
