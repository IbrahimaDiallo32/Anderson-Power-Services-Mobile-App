import React, { useState } from 'react';
import {
  StyleSheet,
  Text,
  View,
  TextInput,
  TouchableOpacity,
  ImageBackground,
  Image,
  SafeAreaView,
  ScrollView,
} from 'react-native';
import { useNavigation } from '@react-navigation/native';
import { Spacing, Color, FontFamily, FontSize, BorderRadius } from '../theme/themes.ts';

const Login = () => {
  const navigation = useNavigation();
  const [email, setEmail] = useState('');

  return (
    <ImageBackground
      source={require('../assets/images/map.png')}
      resizeMode="cover"
      blurRadius={5}
      style={styles.background}
    >
      <SafeAreaView style={styles.safeArea}>
        <View style={styles.logoContainer}>
          <Image
            source={require('../assets/images/anderson-power-logo.png')}
            style={styles.logo}
            resizeMode="contain"
          />
        </View>

            <Text style={styles.label}>Enter your Email</Text>
            <TextInput
              style={styles.input}
              placeholder="Email"
              secureTextEntry
              value={email}
              onChangeText={setEmail}
              placeholderTextColor={Color.gray}
            />

            <TouchableOpacity
              style={styles.button}
              onPress={() => navigation.navigate('Login')}
            >
              <Text style={styles.buttonText}>Send Email</Text>
            </TouchableOpacity>
          </View>
        </ScrollView>
      </SafeAreaView>
    </ImageBackground>
  );
};

export default Login;

const styles = StyleSheet.create({
  background: {
    flex: 1,
  },
  safeArea: {
    flex: 1,
  },
  logoContainer: {
    backgroundColor: Color.white, // White background for the top logo section
    paddingTop: 20,
    alignItems: 'center',
    paddingBottom: 10,
  },
  logo: {
    width: 180, // Adjust size as needed
    height: 60,
  },
  scrollContainer: {
    flexGrow: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  container: {
    backgroundColor: Color.white,
    padding: Spacing.space_50,
    borderRadius: BorderRadius.radius_20,
    width: '80%',
    alignItems: 'center',
    shadowColor: Color.grayDark,
    shadowOffset: { width: 0, height: 2 },
    shadowOpacity: 0.1,
    shadowRadius: 4,
  },
  label: {
    fontSize: FontSize.size_normal,
    fontFamily: FontFamily.montserrat_regular,
    marginBottom: Spacing.space_20,
  },
  input: {
    width: '100%',
    height: 40,
    borderColor: Color.gray,
    borderWidth: 1,
    borderRadius: BorderRadius.radius_8,
    paddingHorizontal: Spacing.space_20,
    marginBottom: Spacing.space_30,
    fontFamily: FontFamily.sansSerif_regular,
  },
  button: {
    backgroundColor: Color.red,
    width: '100%',
    paddingVertical: Spacing.space_20,
    borderRadius: BorderRadius.radius_30,
    alignItems: 'center',
    marginVertical: Spacing.space_20,
  },
  buttonText: {
    color: Color.white,
    fontSize: FontSize.size_medium,
    fontFamily: FontFamily.montserrat_bold,
  },
  linkText: {
    color: Color.primary,
    textDecorationLine: 'underline',
    fontSize: FontSize.size_small,
    marginVertical: Spacing.space_20,
  },
});