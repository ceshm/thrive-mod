package com.ceshm.citrus.block;

import com.ceshm.citrus.Citrus;
import com.ceshm.citrus.item.ModItemGroup;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block TANZANITE_BLOCK = registerBlock(
            "tanzanite_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
            ModItemGroup.CITRUS_MAIN
    );
    public static final Block TANZANITE_ORE = registerBlock(
            "tanzanite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
            ModItemGroup.CITRUS_MAIN
    );
    public static final Block DEEPSLATE_TANZANITE_ORE = registerBlock(
            "deepslate_tanzanite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()),
            ModItemGroup.CITRUS_MAIN
    );

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registries.BLOCK, new Identifier(Citrus.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(block));
        return Registry.register(
                Registries.ITEM,
                new Identifier(Citrus.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings())
        );
    }

    public static void registerModBlocks() {

    }
}
