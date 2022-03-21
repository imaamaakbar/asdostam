import 'package:belajar_dart/belajar_dart.dart' as belajar_dart;
import 'dart:io';

Future<void> main() async {
  print('Fetching username...');
  var username = fetchUsername();
  print('You are logged in as $username');
  print('Welcome!');
}

Future<String> fetchUsername() {
  return Future.delayed(Duration(seconds: 3), () => 'DartUser');
}

