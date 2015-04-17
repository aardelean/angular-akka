'use strict';

var gulp = require('gulp');

gulp.paths = {
  bower: 'src/webapp/bower',
  src: 'src/webapp/js',
  dist: 'target/webapp',
  tmp: 'target/webapp',
  views: 'server/views'
};

require('require-dir')('./gulp');

gulp.task('default', [''], function() {
  gulp.start('typescript');
});
