FROM node:11-alpine as BUILD

COPY . /root/app
WORKDIR /root/app
RUN npm install
RUN npm run build

FROM nginx:1.15-alpine
EXPOSE 80
COPY --from=BUILD /root/app/dist /usr/share/nginx/html

CMD ["nginx", "-g", "daemon off;"]
