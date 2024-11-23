// App.js
import React, { useState, useEffect } from 'react';
import { View, Text } from 'react-native';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';

import Wardrobe from './screens/Wardrobe';
import AddClothing from './screens/wardrobe/AddClothing';
import EditClothing from './screens/wardrobe/EditClothing';
import { ClothingProvider } from './contexts/ClothingContext'; // Import the provider

const Tab = createBottomTabNavigator();
const Stack = createStackNavigator();

const SplashScreen = ({ onFinish }) => {
  useEffect(() => {
    const timer = setTimeout(() => {
      onFinish();
    }, 2000);
    return () => clearTimeout(timer);
  }, []);

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text style={{ fontSize: 24, fontWeight: 'bold' }}> SeekFit </Text>
    </View>
  );
};

const ComingSoon = () => (
  <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
    <Text style={{ fontSize: 18 }}>Coming Soon!</Text>
  </View>
);

function WardrobeStack() {
  return (
    <Stack.Navigator>
      <Stack.Screen name="Wardrobe" component={Wardrobe} />
      <Stack.Screen name="AddClothing" component={AddClothing} />
      <Stack.Screen name="EditClothing" component={EditClothing} />
    </Stack.Navigator>
  );
}

export default function App() {
  const [showSplash, setShowSplash] = useState(true);

  if (showSplash) {
    return <SplashScreen onFinish={() => setShowSplash(false)} />;
  }

  return (
    <ClothingProvider>
      <NavigationContainer>
        <Tab.Navigator>
          <Tab.Screen name="WardrobeTab" component={WardrobeStack} options={{ headerShown: false }} />
          <Tab.Screen name="Friends" component={ComingSoon} />
          <Tab.Screen name="Planner" component={ComingSoon} />
        </Tab.Navigator>
      </NavigationContainer>
    </ClothingProvider>
  );
};