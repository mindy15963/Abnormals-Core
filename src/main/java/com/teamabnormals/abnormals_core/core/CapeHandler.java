package com.teamabnormals.abnormals_core.core;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

import com.google.common.collect.ImmutableSet;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AbnormalsCore.MODID)
public class CapeHandler {
	
	private static final ImmutableSet<String> UUIDS = ImmutableSet.of(
			"8ed04941-c497-4caf-80b2-ccf2e821d94d",  //bagel
			"b8b859a5-2dbc-4743-8f7a-4768f6692606",  //smelly
			"4d568080-07a5-4961-96b2-3811f9721aa2",  //five
			"caaeff74-cbbc-415c-9c22-21e65ad6c33f",  //cam
			"4378df24-8433-4b5c-b865-bf635b003ebb"); //farcr
	
	private static final Set<String> ADDED_UUIDS = Collections.newSetFromMap(new WeakHashMap<>());
	
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public static void onRenderPlayer(RenderPlayerEvent.Post event) {
		PlayerEntity player = event.getPlayer();
		String uuid = PlayerEntity.getUUID(player.getGameProfile()).toString();
		if(player instanceof AbstractClientPlayerEntity && UUIDS.contains(uuid) && !ADDED_UUIDS.contains(uuid)) {
			AbstractClientPlayerEntity clientPlayer = (AbstractClientPlayerEntity) player;
			if(clientPlayer.hasPlayerInfo()) {
				addTexture(clientPlayer, MinecraftProfileTexture.Type.CAPE);
				addTexture(clientPlayer, MinecraftProfileTexture.Type.ELYTRA);
				ADDED_UUIDS.add(uuid);
			}
		}
	}
	
	public static void addTexture(AbstractClientPlayerEntity player, MinecraftProfileTexture.Type type) {
		NetworkPlayerInfo playerInfo = player.playerInfo;
		playerInfo.playerTextures.put(type, new ResourceLocation("abnormals_core", "textures/abnormals_cape.png"));
	}
}