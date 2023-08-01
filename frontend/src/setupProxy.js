const { createProxyMiddleware } = require('http-proxy-middleware');
//Proxy to avoid cors
module.exports = function(app) {
  app.use(
    '/generator-service',
    createProxyMiddleware({
      target: 'http://localhost:8081/',
      changeOrigin: true,
    })
  );
  
  app.use(
    '/validator-service',
    createProxyMiddleware({
      target: 'http://localhost:8082',
      changeOrigin: true,
    })
  );
};