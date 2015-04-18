'use strict';

var gulp = require('gulp');

gulp.paths = {
  bower: 'bower',
  src: 'src/client',
  dist: 'target/webapp',
  tmp: 'target/webapp',
  views: 'server/views'
};

require('require-dir')('./gulp');

gulp.task('default', [''], function() {
  gulp.start('typescript');
});
