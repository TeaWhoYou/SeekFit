// screens/Wardrobe.js
import React from 'react';
import { createMaterialTopTabNavigator } from '@react-navigation/material-top-tabs';
import { createStackNavigator } from '@react-navigation/stack';

import Clothes from './wardrobe/Clothes';
import ClothingForm from './wardrobe/ClothingForm';
import Outfits from './wardrobe/Outfits';
import OutfitForm from './wardrobe/OutfitForm';
import FilterClothing from './wardrobe/FilterClothing'; 
import FilterOutfit from './wardrobe/FilterOutfit'; // Import the new filtering screen for outfits

const Stack = createStackNavigator();
const TopTab = createMaterialTopTabNavigator();

function WardrobeTabs() {
  return (
    <TopTab.Navigator>
      <TopTab.Screen name="Clothes" component={Clothes} />
      <TopTab.Screen name="Outfits" component={Outfits} />
    </TopTab.Navigator>
  );
}

export default function Wardrobe() {
  return (
    <Stack.Navigator>
      <Stack.Screen
        name="WardrobeTabs"
        component={WardrobeTabs}
        options={{ headerShown: false }} 
      />
      <Stack.Screen
        name="ClothingForm"
        component={ClothingForm}
        options={{ headerShown: false }} 
      />
      <Stack.Screen
        name="OutfitForm"
        component={OutfitForm}
        options={{ headerShown: false }} 
      />
      <Stack.Screen
        name="FilterClothing"
        component={FilterClothing}
        options={{ headerShown: false }} 
      />
      <Stack.Screen
        name="FilterOutfit"
        component={FilterOutfit}
        options={{ headerShown: false }} 
      />
    </Stack.Navigator>
  );
}

