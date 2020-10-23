'use strict';

var util = require('../util');

var SequencePart = function(expression, label, muted) {
  this._expression = expression;
  this._label      = label;
  this._muted      = muted;
};

util.assign(SequencePart.prototype, {
  toSexp: function() {
    var expression = this._expression.toSexp();
    if (this._label) expression = ['label', this._label, expression];
    if (this._muted) expression = ['mute', expression];
    return expression;
  },

  forEach: function(callback, context) {
    callback.call(context, this._expression);
  },

  labels: function() {
    var labels = [];
    if (this._label) labels.push(this._label);
    if (this._expression.refName) labels.push(this._expression.refName);
    return labels;
  },

  muted: function() {
    return this._muted;
  },

  compile: function(builder, address) {
    this._expression.compile(builder, address);
  }
});

module.exports = SequencePart;
