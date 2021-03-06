package com.teamabnormals.abnormals_core.core.examples;

import com.teamabnormals.abnormals_core.core.AbnormalsCore;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbnormalsCore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ExampleSoundRegistry {
	public static final RegistryHelper HELPER = AbnormalsCore.REGISTRY_HELPER;
	
	public static final RegistryObject<SoundEvent> AMBIENCE_EXAMPLE = HELPER.createSoundEvent("ambient.end_city.test");
}