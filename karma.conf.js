'use strict';

var wiredep = require('wiredep');
var bowerDeps = wiredep({
  directory: 'bower',
  exclude: ['bootstrap-sass-official'],
  dependencies: true,
  devDependencies: true
});

var bowerFiles = bowerDeps.js.map(function(file) {
  return './' + file;
});

var files = bowerFiles.concat([
  './.tmp/src/client/register.js',
  './.tmp/src/client/index.js',
  './.tmp/src/client/templateCacheHtml.js',
  './.tmp/src/client/**/*.js',
  './.tmp/src/client/**/*.mock.js',
  './.tmp/src/client/**/*.spec.js'
]);

var exclude = [];

module.exports = function(config) {
  config.set({
    autoWatch: false,

    frameworks: ['jasmine'],

    reporters: ['mocha'],

    browsers: ['PhantomJS'],

    captureTimeout: 60000,

    plugins: [
      'karma-mocha-reporter',
      'karma-phantomjs-launcher',
      'karma-chrome-launcher',
      'karma-firefox-launcher',
      'karma-jasmine'
    ],

    files: files,
    exclude: exclude
  });
};
