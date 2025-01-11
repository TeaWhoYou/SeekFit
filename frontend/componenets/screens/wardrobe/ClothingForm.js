// screens/wardrobe/EditClothing.js
import React, { useState, useEffect } from 'react';
import { View, Text, TouchableOpacity, TextInput, Image, StyleSheet, ScrollView } from 'react-native';
import * as ImagePicker from 'expo-image-picker';
import { useClothing } from '../../../contexts/ClothingContext';
import { clothingTagValues } from '../../../contexts/ClothingTagValuesContext'; 
import TagsInput from '../../TagsInput';

export default function ClothingForm({ route, navigation }) {
  const { addClothing, editClothing, removeClothing } = useClothing();
  const { clothingToEdit } = route.params || {};

  const [image, setImage] = useState(clothingToEdit ? clothingToEdit.image : null);
  const [description, setDescription] = useState(clothingToEdit ? clothingToEdit.description : '');
  const [colorTags, setColorTags] = useState(clothingToEdit ? clothingToEdit.colorTags : []);
  const [typeTags, setTypeTags] = useState(clothingToEdit ? clothingToEdit.weatherTags : []);
  const [materialTags, setMaterialTags] = useState(clothingToEdit ? clothingToEdit.materialTags : []);
  const [statusTags, setStatusTags] = useState(clothingToEdit ? clothingToEdit.statusTags : []);
  
  const colorValues = clothingTagValues.Color;
  const materialValues = clothingTagValues.Material;
  const statusValues = clothingTagValues.Status;
  const typeValues = clothingTagValues.Type;

  const selectImage = async () => {
    const { status } = await ImagePicker.requestMediaLibraryPermissionsAsync();
    if (status !== 'granted') {
      alert('Permission to access gallery is required!');
      return;
    }

    const result = await ImagePicker.launchImageLibraryAsync({
      mediaTypes: ImagePicker.MediaTypeOptions.Images,
      allowsEditing: false,
      quality: 1,
    });

    if (!result.canceled && result.assets && result.assets.length > 0) {
      setImage(result.assets[0].uri);  
    }
  };

  const saveClothing = async () => {
    if (image) {
      const clothingData = { 
        image, 
        description, 
        colorTags, 
        typeTags,
        materialTags,
        statusTags
      };

      if (clothingToEdit) {
        await editClothing(clothingToEdit.id, clothingData);
      } else {
        const newClothing = { id: new Date().toString(), ...clothingData };
        await addClothing(newClothing);
      }

      navigation.goBack();
    } else {
      alert('Please add an image.');
    }
  };

  const deleteClothing = async () => {
    if (clothingToEdit) {
      await removeClothing(clothingToEdit.id);
      navigation.goBack();
    }
  };

  return (
    <ScrollView contentContainerStyle={styles.container}>
      <TouchableOpacity style={styles.imagePicker} onPress={selectImage}>
        {image ? (
          <Image source={{ uri: image }} style={styles.image} />
        ) : (
          <Text style={styles.imagePickerText}>Add Picture +</Text>
        )}
      </TouchableOpacity>

      <TextInput
        style={styles.input}
        placeholder="Description"
        value={description}
        onChangeText={setDescription}
      />
      <TagsInput 
        name={'Type'}
        tags={typeTags}
        values={typeValues}
        onTagsChange={setTypeTags}
      />
      <TagsInput 
        name={'Color'}
        tags={colorTags}
        values={colorValues}
        onTagsChange={setColorTags}
      />
      <TagsInput 
        name={'Material'}
        tags={materialTags}
        values={materialValues}
        onTagsChange={setMaterialTags}
      />
      <TagsInput 
        name={'Status'}
        tags={statusTags}
        values={statusValues}
        onTagsChange={setStatusTags}
      />

      <TouchableOpacity style={styles.saveButton} onPress={saveClothing}>
        <Text style={styles.saveButtonText}>Save</Text>
      </TouchableOpacity>

      {clothingToEdit && (
        <TouchableOpacity style={styles.deleteButton} onPress={deleteClothing}>
          <Text style={styles.deleteButtonText}>Delete</Text>
        </TouchableOpacity>
      )}
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: {
    padding: 20,
  },
  imagePicker: {
    height: 600,
    backgroundColor: '#ddd',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 20,
  },
  imagePickerText: {
    fontSize: 16,
    color: '#888',
  },
  image: {
    width: '100%',
    height: '100%',
    borderRadius: 10,
  },
  input: {
    borderWidth: 1,
    borderColor: '#ccc',
    padding: 10,
    marginBottom: 20,
  },
  saveButton: {
    backgroundColor: '#28a745',
    padding: 10,
    alignItems: 'center',
    borderRadius: 5,
    marginBottom: 20,
    marginBottom: 20,
  },
  saveButtonText: {
    color: 'white',
    fontSize: 16,
  },
  deleteButton: {
    backgroundColor: '#dc3545',
    padding: 10,
    alignItems: 'center',
    borderRadius: 5,
  },
  deleteButtonText: {
    color: 'white',
    fontSize: 16,
  },
  deleteButton: {
    backgroundColor: '#dc3545',
    padding: 10,
    alignItems: 'center',
    borderRadius: 5,
  },
  deleteButtonText: {
    color: 'white',
    fontSize: 16,
  },
});